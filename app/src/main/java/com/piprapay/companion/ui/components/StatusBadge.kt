package com.piprapay.companion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.piprapay.companion.ui.theme.Success
import com.piprapay.companion.ui.theme.SuccessBg
import com.piprapay.companion.ui.theme.Error
import com.piprapay.companion.ui.theme.ErrorBg
import com.piprapay.companion.ui.theme.Primary

@Composable
fun StatusBadge(
    status: String,
    modifier: Modifier = Modifier
) {
    val (backgroundColor, textColor) = when (status.uppercase()) {
        "STORED" -> SuccessBg to Success
        "USED" -> Primary.copy(alpha = 0.1f) to Primary
        "ERROR" -> ErrorBg to Error
        else -> SuccessBg to Success
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .padding(horizontal = 12.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = status.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            color = textColor
        )
    }
}
