package com.piprapay.companion.ui.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import com.piprapay.companion.ui.theme.CardBackground
import com.piprapay.companion.ui.theme.Error
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.ToggleOff

@Composable
fun SettingsScreen() {
    var serviceStatus by remember { mutableStateOf(true) }
    var smsPermission by remember { mutableStateOf(true) }
    var batteryOptimization by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = CardBackground)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Shahrial Amin",
                    style = MaterialTheme.typography.titleLarge,
                    color = TextPrimary
                )
                Text(
                    text = "shahrial741@gmail.com",
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextSecondary
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = CardBackground)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Service Status",
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextPrimary,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = serviceStatus,
                        onCheckedChange = { serviceStatus = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = MaterialTheme.colorScheme.background,
                            checkedTrackColor = Primary,
                            uncheckedThumbColor = MaterialTheme.colorScheme.background,
                            uncheckedTrackColor = ToggleOff
                        )
                    )
                }

                HorizontalDivider(color = MaterialTheme.colorScheme.outline)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "SMS Permission",
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextPrimary,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = smsPermission,
                        onCheckedChange = { smsPermission = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = MaterialTheme.colorScheme.background,
                            checkedTrackColor = Primary,
                            uncheckedThumbColor = MaterialTheme.colorScheme.background,
                            uncheckedTrackColor = ToggleOff
                        )
                    )
                }

                HorizontalDivider(color = MaterialTheme.colorScheme.outline)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Battery optimization permission",
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextPrimary,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = batteryOptimization,
                        onCheckedChange = { batteryOptimization = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = MaterialTheme.colorScheme.background,
                            checkedTrackColor = Primary,
                            uncheckedThumbColor = MaterialTheme.colorScheme.background,
                            uncheckedTrackColor = ToggleOff
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = CardBackground)
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Delete SMS Data",
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextPrimary,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Navigate",
                        tint = TextSecondary
                    )
                }

                HorizontalDivider(color = MaterialTheme.colorScheme.outline)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Logout",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Error,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Navigate",
                        tint = Error
                    )
                }
            }
        }
    }
}
