package com.example.profile.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profile.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    var searchHistory = listOf(
        "Civil", "Electric", "Architecture",
        "Programming", "Bena", "Smart", "Vlaue", "Science",
        "Volley", "Route", "Ear Soft", "bolley", "Amal", "Waffa", "Saraha"
    )

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        SearchBar(
            query = query,
            onQueryChange = { query = it },
            onSearch = { newQuery ->
                println("Performing search on query:$newQuery")
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {
                Text(text = "Search")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            },
            trailingIcon = {
                Row {
                    IconButton(onClick = {
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_mic_24),
                            contentDescription = "Close"
                        )
                    }
                    if (active) {
                        IconButton(onClick = {
                            if (query.isNotEmpty()) query = "" else active = false
                        }) {
                            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
                        }
                    }
                }
            }
        ) {
            //   searchHistory.takeLast(3).forEach { item ->
            LazyColumn() {

                items(searchHistory) {
                    searchHistory.forEach { item ->

                        ListItem(modifier = Modifier.clickable { query = item },
                            headlineContent = { Text(text = item) },
                            leadingContent = {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_history_24),
                                    contentDescription = "Close"
                                )
                            }
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                    }

                }

            }
        }
    }
}
