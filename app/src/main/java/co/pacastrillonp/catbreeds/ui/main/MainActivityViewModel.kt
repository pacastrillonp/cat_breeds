package co.pacastrillonp.catbreeds.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.pacastrillonp.catbreeds.model.mapper.catNetworkToCatEntity
import co.pacastrillonp.catbreeds.model.network.regenerate.ListCatsNetworkItem
import co.pacastrillonp.catbreeds.model.persistence.CatEntity
import co.pacastrillonp.catbreeds.persistence.dao.CatDao
import co.pacastrillonp.catbreeds.repository.NetworkRepository
import co.pacastrillonp.catbreeds.util.subscribeOnComputationThread
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivityViewModel(
    private val networkRepository: NetworkRepository,
    private val catDao: CatDao
) : ViewModel() {

    lateinit var disposable: Disposable

    private var localCatsPresentable = emptyList<CatEntity>()

    val catsPresentable: MutableLiveData<List<CatEntity>> by lazy {
        MutableLiveData<List<CatEntity>>(
            emptyList()
        )
    }

    val fetchingData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>(false) }

    val fetchCats: Observable<List<CatEntity>> =
        catDao.getAllCats()
            .subscribeOnComputationThread()
            .distinctUntilChanged()
            .toObservable()
            .doOnNext {
                localCatsPresentable = it
            }

    fun fetchData() {
        fetchingData.postValue(true)
        networkRepository.getCats().toObservable()
            .subscribe(object : Observer<List<ListCatsNetworkItem>> {
                override fun onComplete() {}

                override fun onError(e: Throwable) {
                    Log.d("🔥", "$e")
                }

                override fun onNext(catNetwork: List<ListCatsNetworkItem>) {
                    fetchingData.postValue(false)
                    catDao.insert(catNetwork.mapNotNull {
                        it.catNetworkToCatEntity()
                    })
                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }
            })
    }

    fun updateUserPresentable(cats: List<CatEntity>) {
        localCatsPresentable = cats
        catsPresentable.postValue(localCatsPresentable)
    }

}

