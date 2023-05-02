package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateBizCard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBizCard() {
    ComposeDemoTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = MaterialTheme.colorScheme.background
        ) {
            Card(
                modifier = Modifier
                    .width(width = 200.dp)
                    .height(height = 200.dp)
                    .padding(all = 15.dp),
                shape = RoundedCornerShape(CornerSize(size = 15.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            ) {
                Surface(
                    modifier = Modifier
                        .size(size = 200.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(all = 15.dp),
                    shape = CircleShape,
                    shadowElevation = 4.dp,
                    border = BorderStroke(width = 0.5.dp, color = Color.LightGray),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = "profile image",
                        modifier = Modifier.size(size = 135.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CreateBizCard()
}