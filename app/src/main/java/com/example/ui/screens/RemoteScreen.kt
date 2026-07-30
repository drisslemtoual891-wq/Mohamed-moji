package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RemoteScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top section: Power and Mute
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.PowerSettingsNew, contentDescription = "Power", tint = Color.Red)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.VolumeOff, contentDescription = "Mute")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Number Pad
        NumberPad()

        Spacer(modifier = Modifier.height(24.dp))

        // Volume and Channel Controls
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            VolChControl(iconUp = Icons.Filled.Add, iconDown = Icons.Filled.Remove, label = "VOL")
            VolChControl(iconUp = Icons.Filled.KeyboardArrowUp, iconDown = Icons.Filled.KeyboardArrowDown, label = "CH")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // D-Pad
        DPad()

        Spacer(modifier = Modifier.height(24.dp))

        // Color buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorButton(Color.Red)
            ColorButton(Color.Green)
            ColorButton(Color.Yellow)
            ColorButton(Color.Blue)
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Media Keys
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { /*TODO*/ }) { Icon(Icons.Filled.FastRewind, contentDescription = "Rewind") }
            IconButton(onClick = { /*TODO*/ }) { Icon(Icons.Filled.PlayArrow, contentDescription = "Play") }
            IconButton(onClick = { /*TODO*/ }) { Icon(Icons.Filled.Pause, contentDescription = "Pause") }
            IconButton(onClick = { /*TODO*/ }) { Icon(Icons.Filled.FastForward, contentDescription = "Forward") }
            IconButton(onClick = { /*TODO*/ }) { Icon(Icons.Filled.FiberManualRecord, contentDescription = "Record", tint = Color.Red) }
        }
    }
}

@Composable
fun NumberPad() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        for (i in 0..2) {
            Row(
                modifier = Modifier.fillMaxWidth(0.6f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (j in 1..3) {
                    val num = i * 3 + j
                    NumberButton(num.toString())
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Row(
            modifier = Modifier.fillMaxWidth(0.6f),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            NumberButton("*")
            NumberButton("0")
            NumberButton("#")
        }
    }
}

@Composable
fun NumberButton(number: String) {
    Button(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        modifier = Modifier.size(56.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(text = number, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun VolChControl(iconUp: ImageVector, iconDown: ImageVector, label: String) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(24.dp))
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(iconUp, contentDescription = "$label Up")
        }
        Text(text = label, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(iconDown, contentDescription = "$label Down")
        }
    }
}

@Composable
fun DPad() {
    Box(
        modifier = Modifier
            .size(180.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.TopCenter).padding(8.dp)) {
            Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "Up")
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.BottomCenter).padding(8.dp)) {
            Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Down")
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterStart).padding(8.dp)) {
            Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "Left")
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterEnd).padding(8.dp)) {
            Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "Right")
        }
        Button(
            onClick = { /*TODO*/ },
            shape = CircleShape,
            modifier = Modifier.size(64.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "OK", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ColorButton(color: Color) {
    Box(
        modifier = Modifier
            .size(48.dp, 24.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color)
    )
}
