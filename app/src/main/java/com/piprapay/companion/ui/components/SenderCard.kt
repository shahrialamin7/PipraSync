package com.piprapay.companion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextTertiary
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.ToggleOff
import com.piprapay.companion.ui.theme.White

@Composable
fun SenderCard(
    name: String,
    isEnabled: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Sender name - 14sp, poppins_semibold
                Text(
                    text = name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(6.dp))
                // Description - 13sp, grey7EMa
                Text(
                    text = if (isEnabled) "Sender status is enabled. It will update transactions." else "Sender status is disabled.",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextTertiary
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Toggle - 44x24dp
            Switch(
                checked = isEnabled,
                onCheckedChange = onToggle,
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
}
