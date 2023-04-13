package co.pacastrillonp.catbreeds.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.pacastrillonp.catbreeds.model.persistence.CatEntity
import co.pacastrillonp.catbreeds.ui.theme.CatbreedsTheme
import coil.compose.rememberAsyncImagePainter

@Composable
fun CatItem(catEntity: CatEntity) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(300.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp
    ) {
        Surface {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                )
            {
                Text(
                    text = catEntity.breadName, textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(120.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    modifier = Modifier
                        .width(250.dp)
                        .height(250.dp),
                    painter = rememberAsyncImagePainter(catEntity.imageUrl),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Row(
                ) {
                    Text(text = "Pais de origen: ")
                    Text(text = catEntity.origin)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Inteligencia: ")
                    Text(text = catEntity.intelligence.toString())
                    Spacer(modifier = Modifier.width(10.dp))
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CatItemPreview() {
    CatbreedsTheme {
        CatItem(
            CatEntity(
                "0XYvRd7oD",
                "Abyssinian",
                "Egypt",
                5,
                5,
                "https://cdn2.thecatapi.com/images/0XYvRd7oD"
            )
        )
    }
}