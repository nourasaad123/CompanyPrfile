package com.example.profile.composable

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profile.R
import com.example.profile.ui.theme.basicColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentOfBottomSheet() {

    var whatsapp by rememberSaveable {
        mutableStateOf(" ")
    }
    var facebook by rememberSaveable {
        mutableStateOf("  ")
    }
    var linkedIn by rememberSaveable {
        mutableStateOf("  ")
    }

    var location by rememberSaveable {
        mutableStateOf(" ")
    }
    Column (modifier= Modifier.fillMaxSize()){
        Row(
            horizontalArrangement = Arrangement.Center) {
            TextField(
                value = whatsapp,
                onValueChange = {
                    whatsapp = it
                },
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier
                    .padding(top = 6.dp, start = 40.dp, end = 20.dp),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.whatsapp),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = "phone number")

                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8A97B7),
                    unfocusedBorderColor = Color(0xFF8A97B7),
                    focusedLabelColor = Color(0xFF8A97B7)
                ),
                singleLine = true,

                )

        }
        Spacer(modifier = Modifier.height(20.dp))
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
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text ="facebook")

                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8A97B7),
                    unfocusedBorderColor = Color(0xFF8A97B7),
                    focusedLabelColor = Color(0xFF8A97B7)
                ),
                singleLine = true,

                )

        }
        Spacer(modifier = Modifier.height(20.dp))

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
                        Image(
                            painter = painterResource(id = R.drawable.linkedin),
                            contentDescription = null
                        )
                },
                label = {
                    Text(text = "linkedIn")

                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8A97B7),
                    unfocusedBorderColor = Color(0xFF8A97B7),
                    focusedLabelColor = Color(0xFF8A97B7)
                ),
                singleLine = true,

                )

        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.Center) {
            TextField(
                value = location,
                onValueChange = {
                    location = it
                },
                shape = RoundedCornerShape(26.dp),
                modifier = Modifier
                    .padding(top = 6.dp, start = 40.dp, end = 20.dp, bottom = 60.dp),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = "address")

                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFF8A97B7),
                    unfocusedBorderColor = Color(0xFF8A97B7),
                    focusedLabelColor = Color(0xFF8A97B7)
                ),
                singleLine = true,

                )

        }
        Spacer(modifier = Modifier.height(6.dp))
        Button(
            onClick = {
            //    Toast.makeText(context, "Data Saved", Toast.LENGTH_SHORT).show()

            }, colors = ButtonDefaults.buttonColors(basicColor),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
                .clip(RoundedCornerShape(15.dp))

        ) {
            Text(text = "Save")
        }

    }
}