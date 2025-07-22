package com.example.askaichatbot.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.askaichatbot.MainActivity
import com.example.askaichatbot.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroScreen {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}

@Composable
fun IntroScreen(onGetStartedClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            val (backgroundImage, logoImg, titleTxt, subtitleTxt, buttonBox) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.background_intro),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(backgroundImage) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .height(700.dp),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = "ChatBot",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff3d33a8),
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(titleTxt) {
                        top.linkTo(parent.top, margin = 64.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(logoImg) {
                        top.linkTo(titleTxt.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .width(300.dp)
                    .height(300.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "ChatBot App",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff3d33a8),
                modifier = Modifier
                    .constrainAs(subtitleTxt) {
                        top.linkTo(logoImg.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )

            GetStartedButton(
                onClick = onGetStartedClick,
                modifier = Modifier
                    .padding(top = 32.dp, bottom = 24.dp)
                    .constrainAs(buttonBox) {
                        top.linkTo(subtitleTxt.bottom, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Composable
fun GetStartedButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.teal_200),
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(50.dp),
        modifier = modifier
            .fillMaxWidth(0.9f)
            .height(50.dp)
    ) {
        Text(
            text = "Get Started",
            fontSize = 22.sp
        )
    }
}
