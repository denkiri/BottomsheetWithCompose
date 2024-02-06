# BottomsheetWithJetpackCompose
This example demonstrates how to make a Jetpack Compose Bottom sheet dialog. 
# Overview
1. I have used [Material Design Modal bottom sheets](https://developer.android.com/reference/kotlin/androidx/compose/material3/package-summary#ModalBottomSheet(kotlin.Function0,androidx.compose.ui.Modifier,androidx.compose.material3.SheetState,androidx.compose.ui.unit.Dp,androidx.compose.ui.graphics.Shape,androidx.compose.ui.graphics.Color,androidx.compose.ui.graphics.Color,androidx.compose.ui.unit.Dp,androidx.compose.ui.graphics.Color,kotlin.Function0,androidx.compose.foundation.layout.WindowInsets,androidx.compose.material3.ModalBottomSheetProperties,kotlin.Function1)) to display icons with descriptions.
2. expanding and collapsing the sheet is done using [SheetState](https://developer.android.com/reference/kotlin/androidx/compose/material3/SheetState).SheetState provides access to the show and hide functions, as well as properties related to the current sheet state.
3. Implemented [LazyVerticalGrid](https://jetpackcomposeworld.com/lazyverticalgrid-in-jetpack-compose/) to display icons
4. ```
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
                                    "icon",
                                )
                                Spacer(modifier = Modifier.padding(8.dp))
                                Text(text = bottomSheetItems[it].title)
                            }

                        })
                    }
   ```
# Screenshots
<img src="https://github.com/denkiri/ComposeLoginApp/blob/master/Screenshot_20240205_231055.png" width="250" height="540">|<img src="https://github.com/denkiri/ComposeLoginApp/blob/master/Screenshot_20240205_231033.png" width="250" height="540">
<img src="https://github.com/denkiri/ComposeLoginApp/blob/master/Screenshot_20240205_230923.png" width="250" height="540">|<img src="https://github.com/denkiri/ComposeLoginApp/blob/master/Screenshot_20240205_231007.png" width="250" height="540">


