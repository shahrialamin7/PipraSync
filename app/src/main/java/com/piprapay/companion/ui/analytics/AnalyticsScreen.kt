package com.piprapay.companion.ui.analytics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.piprapay.companion.ui.theme.Background
import com.piprapay.companion.ui.theme.ChartError
import com.piprapay.companion.ui.theme.ChartStored
import com.piprapay.companion.ui.theme.ChartUsed
import com.piprapay.companion.ui.theme.TextPrimary
import com.piprapay.companion.ui.theme.TextTertiary
import com.piprapay.companion.ui.theme.White

@Composable
fun AnalyticsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .verticalScroll(rememberScrollState())
    ) {
        // Summary card - white_radius, 16dp margins, 15dp top margin
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 15.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(White)
                .padding(10.dp)
        ) {
            // Header row with icon and title
            Row(
                modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Circle chart icon - 30dp
                Canvas(modifier = Modifier.size(30.dp)) {
                    drawCircle(
                        color = ChartError,
                        radius = size.minDimension / 2
                    )
                    drawCircle(
                        color = White,
                        radius = size.minDimension / 4
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                // Title: "Summery" - 20sp, poppins_medium
                Text(
                    text = "Summery",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextPrimary
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Chart + Legend row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(10.dp)
            ) {
                // PieChart - 150dp
                Canvas(
                    modifier = Modifier.size(150.dp)
                ) {
                    // Stored - purple (#8E59FF)
                    drawArc(
                        color = ChartStored,
                        startAngle = -90f,
                        sweepAngle = 360f,
                        useCenter = true,
                        topLeft = Offset.Zero,
                        size = Size(size.width, size.height)
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                // Legend column
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Stored legend - #8E59FF
                    LegendItem(
                        color = ChartStored,
                        label = "Stored",
                        count = "1"
                    )

                    // Used legend - #20BFF7
                    LegendItem(
                        color = ChartUsed,
                        label = "Used",
                        count = "0"
                    )

                    // Error legend - #FF5555
                    LegendItem(
                        color = ChartError,
                        label = "Error",
                        count = "0"
                    )
                }
            }
        }
    }
}

@Composable
private fun LegendItem(
    color: Color,
    label: String,
    count: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier.size(10.dp)) {
            drawCircle(color = color)
        }

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextTertiary
        )

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = count,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimary
        )
    }
}
