package com.example.udemy_project_twitter_card_project_1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment

import androidx.compose.ui.tooling.preview.Preview
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
                Divider(
                    thickness = 1.dp,
                    modifier = Modifier.padding(10.dp)
                )
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
                    FilledButton("Say Hi!")
                }
            }

        }
    }
}

@Composable
fun PrincessImage(
    modifier: Modifier = Modifier
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
fun FilledButton(title: String) {
    Button(onClick = { Log.d("Main Button", "Has Clicked") }) {
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