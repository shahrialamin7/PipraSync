package com.piprapay.companion.ui.permission

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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.R
import com.piprapay.companion.ui.theme.ButtonDisabled
import com.piprapay.companion.ui.theme.DividerLight
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.White

@Composable
fun PermissionScreen(
    onContinue: () -> Unit,
    onSkip: () -> Unit = {}
) {
    var isChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        // Top toolbar - 60dp height, white bg, bottom divider
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Back arrow - exact APK drawable (40dp circle with border)
                Image(
                    painter = painterResource(id = R.drawable.ic_back_arrow_pay),
                    contentDescription = "Back",
                    modifier = Modifier.size(40.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                // Title: "We Need Access" - 20sp, poppins_medium, centered
                Text(
                    text = "We Need Access",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary,
                    modifier = Modifier.padding(end = 56.dp)
                )
            }

            // Divider - 1dp, #F3F3F3
            HorizontalDivider(
                color = DividerLight,
                thickness = 1.dp
            )
        }

        // Content area - scrollable
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            // Press icon - exact APK drawable (35dp, main_color tint)
            Image(
                painter = painterResource(id = R.drawable.press),
                contentDescription = "Info",
                modifier = Modifier
                    .size(35.dp)
                    .padding(16.dp)
            )

            // Description text - 15sp, #262626
            Text(
                text = "PipraPay Enterprise Companion requires access to your SMS messages to securely archive and sync business messages for your organization's CRM and back-office systems.\nWe process only pre-approved, system-generated messages from whitelisted business senders. All data is processed locally on your device and transmitted securely to your enterprise dashboard. Personal SMS, OTPs, and call logs are never accessed.\nYou can view which messages are synced via the app log for full transparency. Access is required for enterprise record-keeping and audit purposes.",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = TextPrimary,
                modifier = Modifier.padding(16.dp),
                lineHeight = 22.sp
            )
        }

        // Bottom section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // Checkbox row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary,
                        uncheckedColor = TextSecondary
                    )
                )

                Text(
                    text = "I understand and agree ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary
                )

                Text(
                    text = "Privacy Policy",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Primary
                )
            }

            // Give Permissions button - disabled by default, enabled when checked
            Button(
                onClick = onContinue,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                enabled = isChecked,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isChecked) Primary else ButtonDisabled,
                    disabledContainerColor = ButtonDisabled
                )
            ) {
                Text(
                    text = "Give Permissions",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = White
                )
            }

            // Footer: "Secure. Private. Trusted." - 14sp, bold, black
            Text(
                text = "Secure. Private. Trusted.",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 28.dp)
            )
        }
    }
}
