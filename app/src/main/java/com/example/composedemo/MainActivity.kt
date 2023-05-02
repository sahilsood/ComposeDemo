package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        val buttonClickState = remember {
            mutableStateOf(false)
        }
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = MaterialTheme.colorScheme.background
        ) {
            Card(
                modifier = Modifier
                    .padding(all = 15.dp),
                shape = RoundedCornerShape(CornerSize(size = 15.dp)),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CreateProfileImage()
                    Divider(thickness = 1.dp)
                    CreateInfoSection()
                    Button(
                        onClick = { buttonClickState.value = !buttonClickState.value },
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp) //this is to remove button's default padding to avoid text from disappearing
                    ) {
                        Text(
                            text = "Portfolio",
                            fontSize = 7.sp,
                        )
                    }
                    if (buttonClickState.value) {
                        Content()
                    } else {
                        Box() {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Porifolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Text(text = item)
        }
    }
}

@Composable
private fun Content() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth()
            .padding(all = 5.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            shape = RoundedCornerShape(corner = CornerSize(size = 5.dp))
        ) {
            Porifolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
private fun CreateInfoSection() {
    Column(modifier = Modifier.padding(all = 5.dp)) {
        Text(
            text = "Sahil Sood",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android Developer",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
        Text(
            text = "@sahilsood28",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
    }
}

@Composable
private fun CreateProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(size = 200.dp)
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CreateBizCard()
}