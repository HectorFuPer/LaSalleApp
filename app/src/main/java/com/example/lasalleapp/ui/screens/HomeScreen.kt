package com.example.lasalleapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lasalleapp.MainActivity
import com.example.lasalleapp.ui.theme.LaSalleAppTheme
import com.example.lasalleapp.R
import com.example.lasalleapp.utils.Logout

@Composable
fun HomeScreen( innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(innerPadding)
    ) {
        //header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                .height(270.dp)
                .background(MaterialTheme.colorScheme.primary)

        ) {
            Image(
                painter = painterResource(id = R.drawable.background_1),
                contentDescription = "background",
                modifier = Modifier.fillMaxWidth().offset(y = 80.dp),
            )
            Row (
                modifier = Modifier.padding(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                //Logo
                Image(
                    painter = painterResource(id = R.drawable.sallebajio_09),
                    contentDescription = "logo",
                    modifier = Modifier.size(70.dp)
                )

                //User
                Column (
                    modifier = Modifier.padding(start = 10.dp).weight(1f)
                ){
                    Text(text = stringResource(id = R.string.welcome_text), color = MaterialTheme.colorScheme.onPrimary, fontSize = 18.sp)
                    Text(text = "Héctor Fuentes", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.W900)
                }

                //Icon
                Icon(
                    imageVector = Logout,
                    contentDescription = "logout",
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

        }

        //Caja con widgets
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-50).dp)
                .padding(horizontal = 24.dp)
                .clip(shape = RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.onPrimary)
                .height(140.dp),
            contentAlignment = Alignment.Center
        ){

        }

        //Body
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(10.dp)
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.news),
                    fontWeight = FontWeight.W900,
                    fontSize = 26.sp
                )

            }
        }
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    LaSalleAppTheme{
        HomeScreen(innerPadding = PaddingValues(0.dp))
    }
}