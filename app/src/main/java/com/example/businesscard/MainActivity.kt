package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainComponent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainComponent(modifier: Modifier = Modifier) {
    Column(
        modifier= modifier
            .fillMaxSize()
            .background(Color(0xFF009688)),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        LogoComponent(modifier=modifier.weight(3f))
        CardInfo(modifier.weight(1f))
    }
}
@Composable
fun LogoComponent(modifier: Modifier){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier,

        ){
        Image(
            painter = painterResource(R.drawable.logo_app),
            contentDescription = "Logo app",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 26.sp,
            modifier = Modifier.padding(10.dp),
            color = Color(0xFFFFFFFF)

        )

        Text(
            text = stringResource(R.string.subtitule),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xff005af3)
        )
    }
}

@Composable
fun CardInfo(modifier: Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom)
    ) {
        CardItem(
            text = "+34 61 79 85 179",
            icon = Icons.Filled.Call,

            )

        CardItem(
            text = "@Cris_Android",
            icon = Icons.Filled.Share,

            )

        CardItem(
            text = "crisfernandoxdpatzifrias@gmail.com",
            icon = Icons.Filled.Email,

            )
    }
}

@Composable
fun CardItem(text: String, icon: ImageVector, modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xff025bf3)
        )

        Text(text = text)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        MainComponent()
    }
}