package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DragHandle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.SignalCellularAlt
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Channel(val number: Int, val name: String, val isEncrypted: Boolean, val signalStrength: Int)

val sampleChannels = listOf(
    Channel(1, "BBC One", false, 95),
    Channel(2, "ITV 1", false, 90),
    Channel(3, "Sky Sports", true, 80),
    Channel(4, "Discovery", true, 75),
    Channel(5, "Al Jazeera", false, 85),
    Channel(6, "Nat Geo", true, 88),
    Channel(7, "MTV", true, 70),
    Channel(8, "CNN", false, 92),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChannelsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(
            title = { Text("Channels & Sat Finder") },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.SignalCellularAlt, contentDescription = "Sat Finder")
                }
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text("Backup DB")
            }
            Button(onClick = { /*TODO*/ }) {
                Text("Restore DB")
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sampleChannels) { channel ->
                ChannelItem(channel)
            }
        }
    }
}

@Composable
fun ChannelItem(channel: Channel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = channel.number.toString().padStart(3, '0'),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.width(40.dp)
            )
            
            Column(modifier = Modifier.weight(1f)) {
                Text(text = channel.name, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.SignalCellularAlt,
                        contentDescription = "Signal",
                        modifier = Modifier.size(14.dp),
                        tint = if (channel.signalStrength > 80) Color.Green else Color.Yellow
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "${channel.signalStrength}%", fontSize = 12.sp, color = Color.Gray)
                }
            }

            if (channel.isEncrypted) {
                Icon(Icons.Filled.Lock, contentDescription = "Encrypted", modifier = Modifier.size(20.dp), tint = Color.Red)
                Spacer(modifier = Modifier.width(8.dp))
            }
            
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(32.dp)) {
                Icon(Icons.Filled.FavoriteBorder, contentDescription = "Favorite", modifier = Modifier.size(20.dp))
            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(32.dp)) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit", modifier = Modifier.size(20.dp))
            }
            Icon(Icons.Filled.DragHandle, contentDescription = "Drag to reorder", modifier = Modifier.padding(start = 8.dp))
        }
    }
}
