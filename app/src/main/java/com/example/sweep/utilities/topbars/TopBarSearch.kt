package com.example.sweep.utilities.topbars

import androidx.compose.foundation.background
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
    CenterAlignedTopAppBar(
        actions = { },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        navigationIcon = { },
        title = {
            Row(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(end = 10.dp)
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
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
                                .size(25.dp)
                        )
                    }
                }

                OutlinedTextField(
                    value = searchValue.value,
                    onValueChange = {
                        searchValue.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.85f)
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
                    trailingIcon = (if(searchValue.value == ""){
                        null
                    } else{
                        trailingIconView
                    })

                )

                Spacer(modifier = Modifier.padding(5.dp))

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
    )
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        TopBarSearch()
    }
}