package com.example.liteprint.ui.screen.nesting_screen.component

import DarkCarrot
import LightCarrot
import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.liteprint.NestingScreenViewModel
import com.example.liteprint.MainActivity
import com.example.liteprint.ui.custom.GradientButton
import com.example.liteprint.ui.screen.main.HeaderText

@Composable
fun SendButton(
    viewModel: NestingScreenViewModel,
    activity: MainActivity
) {

    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(30.dp),
        contentAlignment = Alignment.Center
    ) {
        GradientButton(
            gradient = Brush.horizontalGradient(
                colors = listOf(
                    DarkCarrot,
                    LightCarrot
                )
            ),
            {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                activity.startActivity(shareIntent)
            },
            shape = RoundedCornerShape(0.dp, 0.dp, 5.dp, 5.dp)
        )
        HeaderText(text = "отправить", fontSize = 18)
    }
}