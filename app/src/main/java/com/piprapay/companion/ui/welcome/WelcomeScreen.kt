package com.piprapay.companion.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.R
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.White

@Composable
fun WelcomeScreen(
    onContinue: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            // Title: "Get Started" - 27sp, poppins_semibold
            Text(
                text = "Get Started",
                fontSize = 27.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(5.dp))

            // Subtitle: 15sp, greyMa, center aligned
            Text(
                text = "Set up PipraPay to securely archive\nand sync your enterprise messages.",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = TextSecondary,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Logo: 160x160dp
            Image(
                painter = painterResource(id = R.drawable.main_logo),
                contentDescription = "PipraPay Logo",
                modifier = Modifier.size(160.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Continue button - full width, 16dp margins
            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                )
            ) {
                Text(
                    text = "Continue",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Privacy text - 14sp, greyMa with bold purple "Privacy Policy"
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = TextSecondary, fontWeight = FontWeight.Normal)) {
                        append("By continuing you agree to our ")
                    }
                    withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Bold)) {
                        append("Privacy Policy")
                    }
                },
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 28.dp)
            )
        }
    }
}
