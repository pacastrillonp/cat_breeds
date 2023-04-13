package co.pacastrillonp.catbreeds.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.pacastrillonp.catbreeds.ui.components.CatItem
import co.pacastrillonp.catbreeds.ui.components.Loading
import co.pacastrillonp.catbreeds.ui.theme.CatbreedsTheme
import co.pacastrillonp.catbreeds.util.subscribeOnComputationThread
import co.pacastrillonp.catbreeds.util.subscribeOnMainThread
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainActivityViewModel>()

    private val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val cats = viewModel.catsPresentable.observeAsState(listOf())
            val fetchingData = viewModel.fetchingData.observeAsState(false)

            CatbreedsTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (fetchingData.value) {
                            Loading()
                        } else {
                            LazyColumn(contentPadding = PaddingValues(bottom = 150.dp)) {
                                itemsIndexed(
                                    items = cats.value
                                ) { _, cat ->
                                    CatItem(catEntity = cat)
                                }
                            }

                        }
                    }
                }
            }
        }

        viewModel.fetchCats
            .subscribeOnComputationThread()
            .subscribeOnMainThread(disposable) {
                if (it.isEmpty()) {
                    viewModel.fetchData()
                } else {
                    viewModel.updateUserPresentable(it)
                }
            }
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CatbreedsTheme {
    }
}