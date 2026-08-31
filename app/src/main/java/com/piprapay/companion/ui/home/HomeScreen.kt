package com.piprapay.companion.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.piprapay.companion.ui.components.EmptyState
import com.piprapay.companion.ui.components.MessageDetailSheet
import com.piprapay.companion.ui.components.SmsCard
import com.piprapay.companion.ui.components.SyncButton
import com.piprapay.companion.ui.components.TabSelector
import com.piprapay.companion.ui.theme.CardBackground
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary

data class SmsItem(
    val sender: String,
    val simSlot: String,
    val date: String,
    val message: String,
    val status: String
)

@Composable
fun HomeScreen() {
    val tabs = listOf("Pending", "Stored", "Used", "Error")
    var selectedTab by remember { mutableIntStateOf(0) }
    var showDetailSheet by remember { mutableStateOf(false) }
    var selectedSms by remember { mutableStateOf<SmsItem?>(null) }

    val smsList = remember {
        listOf(
            SmsItem("bkash", "1", "Aug 31, 2026 04:46 AM", "You have received Tk 30.00 from 01540700001. Fee Tk 0.00. Balance Tk 45.09. TrxID DHV30VXRGB at 31/08/2026 10:46", "STORED")
        )
    }

    val filteredSms = when (selectedTab) {
        0 -> smsList.filter { it.status == "PENDING" }
        1 -> smsList.filter { it.status == "STORED" }
        2 -> smsList.filter { it.status == "USED" }
        3 -> smsList.filter { it.status == "ERROR" }
        else -> emptyList()
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
                        text = "Good Night,",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )
                    Text(
                        text = "Shahrial Amin",
                        style = MaterialTheme.typography.titleLarge,
                        color = TextPrimary
                    )
                }
                SyncButton(onClick = { })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TabSelector(
            tabs = tabs,
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (filteredSms.isEmpty()) {
            val emptyMessage = when (selectedTab) {
                0 -> "No pending message found"
                1 -> "No stored message found"
                2 -> "No used message found"
                3 -> "No error message found"
                else -> "No message found"
            }
            EmptyState(message = emptyMessage)
        } else {
            LazyColumn {
                items(filteredSms) { sms ->
                    SmsCard(
                        sender = sms.sender,
                        simSlot = sms.simSlot,
                        date = sms.date,
                        message = sms.message,
                        status = sms.status,
                        onClick = {
                            selectedSms = sms
                            showDetailSheet = true
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }

    if (showDetailSheet && selectedSms != null) {
        MessageDetailSheet(
            sender = selectedSms!!.sender,
            status = selectedSms!!.status,
            message = selectedSms!!.message,
            timestamp = selectedSms!!.date,
            simSlot = selectedSms!!.simSlot,
            onDismiss = {
                showDetailSheet = false
                selectedSms = null
            }
        )
    }
}
