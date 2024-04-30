package com.oussama_chatri.a30daysofrecipes

import android.os.Bundle
import android.sax.Element
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oussama_chatri.a30daysofrecipes.ui.theme._30DaysOfRecipesTheme
import java.nio.channels.NotYetBoundException

class MainActivity : ComponentActivity() {
    data class isDark(var isDark : Boolean =  false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDark by remember {
                mutableStateOf(isDark().isDark)
            }
            _30DaysOfRecipesTheme(darkTheme = isDark) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun Element (
    @DrawableRes  photo : Int,
    @StringRes  name :Int,
    @StringRes  ingredients : Int,
    number : Int,
    modifier: Modifier
){
    var ShowMore by remember {
        mutableStateOf(false)
    }
    Card(modifier = modifier.clickable {
        ShowMore = !ShowMore
    }
    ) {
        Column() {
            Text(text ="Day $number :",
                modifier = Modifier.padding(start = 12.dp, bottom = 6.dp),
                style = MaterialTheme.typography.titleSmall
                )
            Text(text = stringResource(id = name),
                modifier = Modifier.padding(start = 12.dp, bottom = 5.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
                )
            Image(painter = painterResource(id = photo), contentDescription = null,
                Modifier
                    .height(200.dp)
                    .padding(start = 12.dp, end = 12.dp, bottom = 10.dp), contentScale = ContentScale.Crop
            )
            if (ShowMore){
                Text(text = stringResource(id = ingredients),
                    Modifier.padding(start = 12.dp, end =12.dp, bottom = 10.dp )
                    , style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}
@Preview
@Composable
fun ElementPreview(){
    com.oussama_chatri.a30daysofrecipes.Element(photo = R.drawable.day1, name = R.string.day1_title, ingredients = R.string.day1_ingredients, modifier = Modifier.padding(1.dp), number = 1)
}

@Composable
fun HomeScreen(){
    LazyVerticalGrid(columns = GridCells.Fixed(1)){
        items(Recipes){item ->
            com.oussama_chatri.a30daysofrecipes.Element(
                photo = item.photo,
                name = item.name,
                ingredients = item.ingredients,
                number = item.number,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _30DaysOfRecipesTheme {
        HomeScreen()
    }
}