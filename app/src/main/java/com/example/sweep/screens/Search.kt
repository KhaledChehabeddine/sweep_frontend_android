package com.example.sweep.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sweep.ui.theme.SweepTheme

@Composable
fun SearchScreen(paddingValues: PaddingValues) {

    Box(
//        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top=100.dp)
            .fillMaxSize()
        ,
    ) {
        Column {
            Text(
                text = "Recent Searches",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(10.dp)
                ,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(10.dp)
            ,
            ) {
                for(i in 1 .. 3){
                    Spacer(modifier = Modifier.padding(5.dp))
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .width(110.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = MaterialTheme.colorScheme.secondaryContainer)
                            .clickable(
                                indication = rememberRipple(
                                    color = MaterialTheme.colorScheme
                                        .onSecondaryContainer
                                ),
                                interactionSource = remember {
                                    MutableInteractionSource()
                                }
                            ) {

                            }
                    ) {

                    }
                }
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Text(
                text = "Categories",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .padding(10.dp)
                ,
            )
            LazyColumn (modifier = Modifier.padding(bottom = 50.dp)){
                item{
                    Column(){
                        for(i in 1 .. 4){
                            Row(){
                                for(i in 1 .. 2){
                                    Column(
                                        modifier = Modifiers
                                            .padding(10.dp)
                                    ){
                                        Box(
                                            modifier = Modifier
                                                .height(100.dp)
                                                .width(170.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(color = MaterialTheme.colorScheme.secondaryContainer)
                                                .clickable(
                                                    indication = rememberRipple(
                                                        color = MaterialTheme.colorScheme
                                                            .onSecondaryContainer
                                                    ),
                                                    interactionSource = remember {
                                                        MutableInteractionSource()
                                                    }
                                                ) {
                                                }
                                        )

                                        Box(
                                            modifier = Modifier
                                                .padding(5.dp)
                                                .height(20.dp)
                                                .width(100.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(color = MaterialTheme.colorScheme.tertiary
                                                )
                                        )
                                        Box(
                                            modifier = Modifier
                                                .height(10.dp)
                                                .width(150.dp)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(color = MaterialTheme.colorScheme.tertiary
                                                )
                                        )
                                        Spacer(modifier = Modifier.padding(10.dp))
                                    }
                                }
                            }
                        }
                    }

                }

            }


        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    SweepTheme {
        SearchScreen(PaddingValues())
    }
}