package com.piprapay.companion.ui.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.ui.theme.Divider
import com.piprapay.companion.ui.theme.Background
import com.piprapay.companion.ui.theme.Error
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.ToggleOff
import com.piprapay.companion.ui.theme.White

@Composable
fun SettingsScreen() {
    var serviceStatus by remember { mutableStateOf(true) }
    var smsPermission by remember { mutableStateOf(true) }
    var batteryOptimization by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .verticalScroll(rememberScrollState())
            .padding(bottom = 20.dp)
    ) {
        // User Profile Card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(White)
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Text(
                text = "Shahrial Amin",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = TextPrimary
            )
            Text(
                text = "shahrial741@gmail.com",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = TextSecondary,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        // Permissions Card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(White)
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            // Service Status - 50dp height
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Service Status",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextPrimary,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = serviceStatus,
                    onCheckedChange = { serviceStatus = it },
                    modifier = Modifier.size(width = 44.dp, height = 24.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = White,
                        checkedTrackColor = Primary,
                        uncheckedThumbColor = White,
                        uncheckedTrackColor = ToggleOff
                    )
                )
            }

            // SMS Permission - 50dp height
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SMS Permission",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextPrimary,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = smsPermission,
                    onCheckedChange = { smsPermission = it },
                    modifier = Modifier.size(width = 44.dp, height = 24.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = White,
                        checkedTrackColor = Primary,
                        uncheckedThumbColor = White,
                        uncheckedTrackColor = ToggleOff
                    )
                )
            }

            // Battery optimization - 50dp height
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Battery optimization permission",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextPrimary,
                    modifier = Modifier.weight(1f)
                )
                Switch(
                    checked = batteryOptimization,
                    onCheckedChange = { batteryOptimization = it },
                    modifier = Modifier.size(width = 44.dp, height = 24.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = White,
                        checkedTrackColor = Primary,
                        uncheckedThumbColor = White,
                        uncheckedTrackColor = ToggleOff
                    )
                )
            }
        }

        // Actions Card
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(White)
                .padding(horizontal = 16.dp, vertical = 5.dp)
        ) {
            // Delete SMS Data - 50dp height
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Delete SMS Data",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = TextPrimary,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = ">",
                    fontSize = 18.sp,
                    color = TextSecondary
                )
            }

            // Divider
            HorizontalDivider(color = Divider)

            // Logout - 50dp height
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Logout",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Error,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = ">",
                    fontSize = 18.sp,
                    color = TextSecondary
                )
            }
        }
    }
}
