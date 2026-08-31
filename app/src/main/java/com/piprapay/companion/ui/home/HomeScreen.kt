package com.piprapay.companion.ui.home

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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.ui.components.EmptyState
import com.piprapay.companion.ui.components.MessageDetailSheet
import com.piprapay.companion.ui.components.SmsCard
import com.piprapay.companion.ui.components.SyncButton
import com.piprapay.companion.ui.theme.Background
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary
import com.piprapay.companion.ui.theme.TextTertiary
import com.piprapay.companion.ui.theme.White

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
            .background(Background)
    ) {
        // Greeting card - white_radius bg, 16dp horiz margins, 10dp top margin
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
                    // Greeting: 13sp, grey7EMa
                    Text(
                        text = "Good Morning,",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = TextTertiary
                    )
                    // Username: poppins_medium
                    Text(
                        text = "Shahrial Amin",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = TextPrimary
                    )
                }
                SyncButton(onClick = { })
            }
        }

        // Tab bar - 4 tabs, weightSum=4
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(White)
                .padding(horizontal = 5.dp, vertical = 8.dp)
        ) {
            tabs.forEachIndexed { index, tab ->
                TabItem(
                    text = tab,
                    isSelected = selectedTab == index,
                    onClick = { selectedTab = index },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

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
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
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

@Composable
private fun TabItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 3.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) White else White)
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextTertiary
        )
    }
}
