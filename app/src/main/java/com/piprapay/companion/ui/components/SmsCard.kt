package com.piprapay.companion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.White

@Composable
fun SmsCard(
    sender: String,
    simSlot: String,
    date: String,
    message: String,
    status: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Status badge colors - from APK screenshots
    val statusColor = when (status.uppercase()) {
        "STORED" -> Color(0xFF22C55E)   // Green
        "PENDING" -> Color(0xFFFFC24B)  // Yellow/orange
        "USED" -> Color(0xFF2280FF)     // Blue
        "ERROR" -> Color(0xFFFF3800)    // Red
        else -> Color(0xFFFF3800)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            // Row 1: Sender + SIM slot + Timestamp
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Sender name - 14sp, poppins_semibold
                Text(
                    text = sender,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.width(5.dp))

                // SIM slot badge - 10sp, #555555, #F1F1F1 bg, 4dp padding
                Text(
                    text = "SIM: $simSlot",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF555555),
                    modifier = Modifier
                        .background(
                            color = Color(0xFFF1F1F1),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 4.dp, vertical = 4.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                // Timestamp - 10sp, #888888
                Text(
                    text = date,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF888888)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Row 2: Message - 13sp, #333333
            Text(
                text = message,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF333333),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Row 3: Status badge - 10sp, white text, colored bg per status
            Text(
                text = status.uppercase(),
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = White,
                modifier = Modifier
                    .background(
                        color = statusColor,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 5.dp)
            )
        }
    }
}
