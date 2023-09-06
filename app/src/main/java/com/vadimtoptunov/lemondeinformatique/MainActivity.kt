package com.vadimtoptunov.lemondeinformatique

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vadimtoptunov.lemondeinformatique.ui.theme.AppMenuTextContent
import com.vadimtoptunov.lemondeinformatique.ui.theme.LeMondeInformatiqueTheme
import com.vadimtoptunov.lemondeinformatique.ui.theme.MenuItemLinks

class MainActivity : ComponentActivity() {
    var url: String = "https://www.lemondeinformatique.fr/actualites/toute-l-actualite.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeMondeInformatiqueTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Blue)
                ) {
                    Card {
                        MainLazyList(AppMenuTextContent())
                    }
                }
            }
        }
    }
}


@Composable
fun MainLazyList(linksList: List<String>) {
    LazyColumn {
        Modifier.fillMaxWidth()
        items(linksList, MenuItemLinks() = {it.id}) { link ->
            LinkCard(link)
        }
    }
}

@Composable
fun LinkCard(link: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        Text(
            text = "$link",
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 20.dp),
            color = Color.Green,
            fontStyle = FontStyle.Normal,
            fontFamily = FontFamily.SansSerif
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeMondeInformatiqueTheme {
        MainLazyList(AppMenuTextContent())
    }
}