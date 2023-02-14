package com.example.sweep.utilities.topbars

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun TopBarSearch() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
        ,
        tonalElevation = 10.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
//                .height(70.dp)
            ,
        ) {
            val searchValue = remember {
                mutableStateOf("")
            }

            val trailingIconView = @Composable{
                        IconButton(
                            onClick = {
                                searchValue.value = ""
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "",
                                modifier = Modifier
//                                    .padding(15.dp)
                                    .size(25.dp)
                            )
                        }
            }

            OutlinedTextField(
                value = searchValue.value,
                onValueChange = {
                    searchValue.value = it
//                    trailingIconView
                                },
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.9f)
                    .padding(10.dp)
                    .align(Alignment.CenterVertically)
                ,
                label = {
                    Text("Search")
                },
                singleLine = true,
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .size(25.dp)
                    )
                },
//                if (!(searchValue.value).equals(TextFieldValue("")))
                trailingIcon = (if(searchValue.value == ""){
                    null
                } else{
                    trailingIconView
                })

            )

            IconButton(
                onClick = {
                    searchValue.value = ""
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(top = 10.dp)

            ) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = "",
                    modifier = Modifier
                        .size(30.dp)
                )
            }
        }
        }
}

//@Composable
//fun SearchBar(
//    hint: String = "",
//    modifier: Modifier = Modifier,
//    onSearch: (String) -> Unit = {}
//) {
//    var text by remember {
//        mutableStateOf("")
//    }
//    var isHintDisplayed by remember {
//        mutableStateOf(hint != "")
//    }
//
//    Box(modifier = Modifier) {
//        BasicTextField(
//            value = text,
//            onValueChange = {
//                text = it
//                onSearch(it)
//            },
//            maxLines = 1,
//            singleLine = true,
//            textStyle = TextStyle(color = Color.Black),
//            modifier = Modifier.fillMaxWidth().background(color = Color.White, shape = CircleShape)
//                .padding(horizontal = 0.dp, vertical = 16.dp)
//        ) {
//
//        }
//    }
//}


@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        TopBarSearch()
    }
}