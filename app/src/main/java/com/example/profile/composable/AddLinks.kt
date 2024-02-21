package com.example.profile.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithBottomSheetForAddLinks(
    value: String,
    onValueChanged: (String) -> Unit
) {
    var isEditing by remember {
        mutableStateOf(false)
    }
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        BottomSheet() {
            showSheet = false
        }
    }
    Column {
        Row(horizontalArrangement = Arrangement.Center) {
            if (isEditing) {
                TextField(
                    value = value,
                    onValueChange = {
                        onValueChanged(value)
                    },
                    shape = RoundedCornerShape(26.dp),
                    modifier = Modifier
                        .padding(top = 6.dp, start = 40.dp, end = 20.dp)
                        .clickable { showSheet = true },
                    trailingIcon = {
                        IconButton(onClick = { isEditing = false }) {
                            Icon(
                                Icons.Filled.Done,
                                contentDescription = null
                            )
                        }

                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF8A97B7),
                        unfocusedBorderColor = Color(0xFF8A97B7),
                        focusedLabelColor = Color(0xFF8A97B7)
                    ),
                    singleLine = true,

                    )

            } else {
                OutlinedTextField(
                    value = value,
                    onValueChange = {
                        onValueChanged(value)
                    },
                    shape = RoundedCornerShape(26.dp),
                    modifier = Modifier
                        .padding(top = 6.dp, start = 40.dp, end = 20.dp)
                        .clickable {
                            showSheet = true
                            isEditing = true
                        },
                    trailingIcon = {
                        IconButton(onClick = { isEditing = true }) {
                            Icon(
                                Icons.Filled.Edit,
                                contentDescription = null
                            )
                        }

                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF8A97B7),
                        unfocusedBorderColor = Color(0xFF8A97B7),
                        focusedLabelColor = Color(0xFF8A97B7)
                    ),
                    singleLine = true,

                    )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        ContentOfBottomSheet()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentOfBottomSheet() {

    var whatsapp by rememberSaveable {
        mutableStateOf(" phone number ")
    }
    var facebook by rememberSaveable {
        mutableStateOf(" facebook ")
    }
    var linkedIn by rememberSaveable {
        mutableStateOf(" linkedIn ")
    }

    var location by rememberSaveable {
        mutableStateOf(" address ")
    }
    Column {
        Row(horizontalArrangement = Arrangement.Center) {
            TextField(
                value = whatsapp,
                onValueChange = {
                    whatsapp = it
                },
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier
                    .padding(top = 6.dp, start = 40.dp, end = 20.dp),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.whatsapp),
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8A97B7),
                    unfocusedBorderColor = Color(0xFF8A97B7),
                    focusedLabelColor = Color(0xFF8A97B7)
                ),
                singleLine = true,

                )

        }
        Row(horizontalArrangement = Arrangement.Center) {
            TextField(
                value = facebook,
                onValueChange = {
                    facebook = it
                },
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier
                    .padding(top = 6.dp, start = 40.dp, end = 20.dp),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8A97B7),
                    unfocusedBorderColor = Color(0xFF8A97B7),
                    focusedLabelColor = Color(0xFF8A97B7)
                ),
                singleLine = true,

                )

        }
        Row(horizontalArrangement = Arrangement.Center) {
            TextField(
                value = linkedIn,
                onValueChange = {
                    linkedIn = it
                },
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier
                    .padding(top = 6.dp, start = 40.dp, end = 20.dp),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8A97B7),
                    unfocusedBorderColor = Color(0xFF8A97B7),
                    focusedLabelColor = Color(0xFF8A97B7)
                ),
                singleLine = true,

                )

        }
        Row(horizontalArrangement = Arrangement.Center) {
            TextField(
                value = location,
                onValueChange = {
                    location = it
                },
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier
                    .padding(top = 6.dp, start = 40.dp, end = 20.dp),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8A97B7),
                    unfocusedBorderColor = Color(0xFF8A97B7),
                    focusedLabelColor = Color(0xFF8A97B7)
                ),
                singleLine = true,

                )

        }


    }
}