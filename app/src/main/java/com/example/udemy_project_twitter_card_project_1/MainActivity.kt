package com.example.udemy_project_twitter_card_project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.udemy_project_twitter_card_project_1.ui.theme.TwitterCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TwitterCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}


@Composable
fun CreateBizCard() {
    val portifolioButtonHandler = remember {
        mutableStateOf(false)

    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(23.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                PrincessImage(
                    modifier = Modifier.size(150.dp)
                        .padding(5.dp)
                )
                SimpleDivider()
                Column(
                    modifier = Modifier.padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    InformationText(
                        "Mrs. Queen of America",
                        "Some loved queen"
                    )
                    FilledButton(
                        "Say Hi!",
                        onClick = { portifolioButtonHandler.value = !portifolioButtonHandler.value })
                    if (portifolioButtonHandler.value) {
                        Content()
                    } else Box() {}

                }

            }

        }

    }
}

@Composable
fun SimpleDivider(thickness: Dp = 3.dp) {
    Divider(thickness = thickness, color = Color.LightGray)
}

@Composable
fun PrincessImage(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier,
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = Color.LightGray),
        shadowElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.princess),
            contentDescription = "princess",
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun InformationText(text: String, description: String) {

    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge
    )
    Text(
        text = description,
        style = MaterialTheme.typography.titleMedium
    )

}

@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Portifolio(listOf("Alicia", "Marina", "Martinez"))


        }
    }
}

@Composable
fun PortifolioRow(header: String) {
    Card(
        modifier = Modifier.padding(8.dp)
            .background(color = Color.Transparent)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)), elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            PrincessImage(
                modifier = Modifier.size(100.dp)
                    .padding(5.dp)
            )
            Text(text = header, fontWeight = FontWeight.Bold)
        }


    }
}

@Composable
fun Portifolio(data: List<String>) {
    LazyColumn {
        items(data) { text ->
            PortifolioRow(header = text)
        }
    }

}

@Composable
fun FilledButton(title: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(title)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TwitterCardTheme {
        CreateBizCard()

    }
}