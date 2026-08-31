package com.piprapay.companion.ui.senders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.piprapay.companion.ui.components.SenderCard
import com.piprapay.companion.ui.theme.CardBackground
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary

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
            .padding(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(containerColor = CardBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Note all settings reset.",
                        style = MaterialTheme.typography.bodySmall,
                        color = TextSecondary
                    )
                    Text(
                        text = "Update Senders",
                        style = MaterialTheme.typography.titleLarge,
                        color = TextPrimary
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Refresh",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
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
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
