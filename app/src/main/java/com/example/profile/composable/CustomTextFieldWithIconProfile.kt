package com.example.profile.composable


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldWithIconProfile(
    value: String,
    onValueChanged: (String) -> Unit,
    label: String,
) {
    var isEditing by remember {
        mutableStateOf(false)
    }
    Row(horizontalArrangement = Arrangement.Center) {
        if (isEditing) {
            OutlinedTextField(
                value = value,
                onValueChange = {
                    onValueChanged(it)
                },
                label = {
                    Text(text = label)

                },
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier
                    .padding(top = 6.dp, start = 40.dp, end = 30.dp),
                trailingIcon = {
                    IconButton(onClick = { isEditing = false }) {
                        Icon(
                            Icons.Filled.Done,
                            //  painter = painterResource(id = R.drawable.baseline_edit_24),
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
        else{
            OutlinedTextField(
                value = value,
                onValueChange = {
                    onValueChanged(it)
                },
                label = {
                    Text(text = label)

                },
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier
                    .padding(top = 6.dp, start = 40.dp, end = 30.dp).clickable {  isEditing=true},
                trailingIcon = {
                    IconButton(onClick = { isEditing = true}) {
                        Icon(
                            Icons.Filled.Edit,
                            //  painter = painterResource(id = R.drawable.baseline_edit_24),
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



