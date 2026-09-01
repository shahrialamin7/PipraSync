package com.piprapay.companion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.R
import com.piprapay.companion.ui.theme.Primary
import com.piprapay.companion.ui.theme.White

@Composable
fun SyncButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Primary)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // "Sync" text - 14sp, white, poppins_medium
        Text(
            text = "Sync",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = White
        )
        Spacer(modifier = Modifier.width(5.dp))
        // Refresh icon - exact APK drawable (20dp, white)
        Image(
            painter = painterResource(id = R.drawable.refresh),
            contentDescription = "Sync",
            modifier = Modifier.size(20.dp)
        )
    }
}
