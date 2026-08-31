package com.piprapay.companion.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.R
import com.piprapay.companion.ui.theme.Background
import com.piprapay.companion.ui.theme.Divider
import com.piprapay.companion.ui.theme.InputBorder
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    var baseUrl by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Back arrow placeholder (would be IconButton in full implementation)
        Text(
            text = "<",
            fontSize = 24.sp,
            color = TextPrimary,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Title: "Login your account" - 23sp, poppins_semibold
        Text(
            text = "Login your account",
            fontSize = 23.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )

        // Subtitle: greyMa
        Text(
            text = "Welcome back, Sign in to your account",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = TextSecondary,
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Payment Panel URL label
        Text(
            text = "Payment Panel URL",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = TextPrimary
        )

        // URL input field
        OutlinedTextField(
            value = baseUrl,
            onValueChange = { baseUrl = it },
            placeholder = { Text("http://pay.example.com") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = InputBorder,
                focusedBorderColor = Primary
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        // One Time Password label
        Text(
            text = "One Time Password",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = TextPrimary
        )

        // Password input field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text("Enter password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = InputBorder,
                focusedBorderColor = Primary
            )
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Login button - full width, 28dp corner radius
        Button(
            onClick = onLoginSuccess,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary
            )
        ) {
            Text(
                text = "Login",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Background
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // OR divider
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Divider,
                thickness = 1.dp
            )
            Text(
                text = "OR",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = TextSecondary,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Divider,
                thickness = 1.dp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // QR Code section
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // QR icon container
            Image(
                painter = painterResource(id = R.drawable.main_logo),
                contentDescription = "QR Login",
                modifier = Modifier.size(70.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Or log in with QR code",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = TextPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 50.dp)
            )
        }
    }
}
