package co.pacastrillonp.catbreeds.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.pacastrillonp.catbreeds.ui.theme.CatbreedsTheme

@Composable
fun Loading() {
    CircularProgressIndicator(
        modifier = Modifier.size(100.dp),
        color = Color.Green,
        strokeWidth = 10.dp

    )
}

@Preview(showBackground = true)
@Composable
fun LoadingPreview() {
    CatbreedsTheme {
        Loading()
    }
}