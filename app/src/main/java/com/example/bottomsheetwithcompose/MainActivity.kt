package com.example.bottomsheetwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bottomsheetwithcompose.ui.theme.BottomsheetWithComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomsheetWithComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeBottomSheet()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeBottomSheet(modifier: Modifier = Modifier) {
    data class BottomSheetItem(val title: String, val icon: ImageVector)
    val bottomSheetItems = listOf(
        BottomSheetItem(title = "Notification", icon = Icons.Default.Notifications),
        BottomSheetItem(title = "Mail", icon = Icons.Default.MailOutline),
        BottomSheetItem(title = "Scan", icon = Icons.Default.Search),
        BottomSheetItem(title = "Edit", icon = Icons.Default.Edit),
        BottomSheetItem(title = "Favorite", icon = Icons.Default.Favorite),
        BottomSheetItem(title = "Settings", icon = Icons.Default.Settings)
    )
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show bottom sheet") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "Show bottom sheet") },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { innerPadding ->
        Column(modifier.padding(innerPadding)) {
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showBottomSheet = false
                    },
                    sheetState = sheetState
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close icon",
                        modifier = modifier
                            .clickable(onClick = {
                                scope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }})
                            .padding(8.dp)
                            .align(Alignment.End)

                    )

                    LazyVerticalGrid(
                        columns=GridCells.Fixed(3)
                    ){
                        items(bottomSheetItems.size, itemContent = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 24.dp, bottom = 24.dp)
                            ) {
                                Spacer(modifier = Modifier.padding(8.dp))
                                Icon(
                                    bottomSheetItems[it].icon,
                                    "",
                                    //tint = Color.White
                                )
                                Spacer(modifier = Modifier.padding(8.dp))
                                Text(text = bottomSheetItems[it].title)
                            }

                        })
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomsheetWithComposeTheme {
        ComposeBottomSheet()
    }
}