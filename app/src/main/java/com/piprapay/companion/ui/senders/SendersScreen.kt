package com.piprapay.companion.ui.senders

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.R
import com.piprapay.companion.ui.components.SenderCard
import com.piprapay.companion.ui.theme.Background
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.TextTertiary
import com.piprapay.companion.ui.theme.White

data class SenderItem(
    val name: String,
    var isEnabled: Boolean = true
)

@Composable
fun SendersScreen() {
    var senders by remember {
        mutableStateOf(
            listOf(
                SenderItem("upay"),
                SenderItem("tallypay"),
                SenderItem("nagad"),
                SenderItem("01847-348685"),
                SenderItem("pathaopay"),
                SenderItem("ibbl ."),
                SenderItem("09638-900800"),
                SenderItem("09678-000005"),
                SenderItem("16216"),
                SenderItem("bkash"),
                SenderItem("16259"),
                SenderItem("telecash"),
                SenderItem("tap.")
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        // Info card - white_radius, 16dp horiz margins, 10dp top margin
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    // "Note all settings reset." - 13sp, grey7EMa
                    Text(
                        text = "Note all settings reset.",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextTertiary
                    )
                    // "Update Senders" - poppins_medium
                    Text(
                        text = "Update Senders",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextPrimary
                    )
                }

                // Refresh icon - exact APK drawable (43dp)
                Image(
                    painter = painterResource(id = R.drawable.updating),
                    contentDescription = "Update Senders",
                    modifier = Modifier.size(43.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        // Sender list
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(senders) { sender ->
                SenderCard(
                    name = sender.name,
                    isEnabled = sender.isEnabled,
                    onToggle = { enabled ->
                        senders = senders.map {
                            if (it.name == sender.name) it.copy(isEnabled = enabled) else it
                        }
                    }
                )
            }
        }
    }
}
