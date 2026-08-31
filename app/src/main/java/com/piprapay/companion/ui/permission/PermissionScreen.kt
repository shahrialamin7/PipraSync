package com.piprapay.companion.ui.permission

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.Background
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary

@Composable
fun PermissionScreen(
    onContinue: () -> Unit,
    onSkip: () -> Unit = {}
) {
    var smsPermission by remember { mutableStateOf(false) }
    var notificationPermission by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Grant Permissions",
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "We need access to your SMS messages to monitor business transactions.",
            style = MaterialTheme.typography.bodyLarge,
            color = TextSecondary
        )
        Spacer(modifier = Modifier.height(24.dp))

        Checkbox(
            checked = smsPermission,
            onCheckedChange = { smsPermission = it },
            colors = CheckboxDefaults.colors(checkedColor = Primary)
        )
        Text(
            text = "SMS Permission (Required)",
            style = MaterialTheme.typography.bodyLarge,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Checkbox(
            checked = notificationPermission,
            onCheckedChange = { notificationPermission = it },
            colors = CheckboxDefaults.colors(checkedColor = Primary)
        )
        Text(
            text = "Notification Permission",
            style = MaterialTheme.typography.bodyLarge,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onContinue,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Primary)
        ) {
            Text(
                text = "Give Permissions",
                style = MaterialTheme.typography.labelLarge,
                color = Background
            )
        }
    }
}
