package com.piprapay.companion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.piprapay.companion.ui.theme.CardBackground
import com.piprapay.companion.ui.theme.Background
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextSecondary

@Composable
fun TabSelector(
    tabs: List<String>,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CardBackground)
            .padding(4.dp)
    ) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = index == selectedTab
            Text(
                text = tab,
                style = MaterialTheme.typography.labelLarge,
                color = if (isSelected) TextPrimary else TextSecondary,
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (isSelected) Background else Color.Transparent)
                    .clickable { onTabSelected(index) }
                    .padding(vertical = 12.dp, horizontal = 8.dp)
            )
        }
    }
}
