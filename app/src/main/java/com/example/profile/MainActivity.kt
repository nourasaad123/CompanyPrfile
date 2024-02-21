package com.example.profile

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.profile.composable.CustomTextFieldWithIconProfile
import com.example.profile.composable.TextFieldWithBottomSheetForAddLinks
import com.example.profile.ui.theme.ProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    val notification = rememberSaveable {
        mutableStateOf("")
    }
    if (notification.value.isNotEmpty()) {
        Toast.makeText(LocalContext.current, notification.value, Toast.LENGTH_LONG).show()
        notification.value = ""
    }
    var editName by rememberSaveable {
        mutableStateOf("")
    }
    var editPassword by rememberSaveable {
        mutableStateOf("")
    }
    var addDescription by rememberSaveable {
        mutableStateOf("")
    }
    var addLinks by rememberSaveable {
        mutableStateOf("add links")
    }
    var updateProject by rememberSaveable {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(30.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 8.dp, end = 8.dp, bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Cancel",
                modifier = Modifier.clickable {
                    notification.value = "Cancelled"
                })
            Text(
                text = "Save",
                modifier = Modifier.clickable { notification.value = "Profile updated" })
        }
        ProfileImage()
        Spacer(modifier = Modifier.height(6.dp))
        CustomTextFieldWithIconProfile(
            value = editName,
            onValueChanged = { editName = it },
            label = "edit name"
        )
        Spacer(modifier = Modifier.height(6.dp))
        CustomTextFieldWithIconProfile(
            value = editPassword,
            onValueChanged = { editPassword = it },
            label = "edit password"
        )
        Spacer(modifier = Modifier.height(6.dp))
        CustomTextFieldWithIconProfile(
            value = addDescription,
            onValueChanged = { addDescription = it },
            label = "add description"
        )

        Spacer(modifier = Modifier.height(6.dp))
        TextFieldWithBottomSheetForAddLinks(
            value = addLinks,
            onValueChanged = { addLinks = it }

        )



        Spacer(modifier = Modifier.height(6.dp))
        CustomTextFieldWithIconProfile(
            value = updateProject,
            onValueChanged = { updateProject = it },
            label = "update project"
        )
    }
}

/*
@Composable
fun ProfileImage() {
    val imageUri = rememberSaveable {
        mutableStateOf("")
    }
    val painter = rememberImagePainter(
        if (imageUri.value.isEmpty())
            R.drawable.baseline_person_24
        else
            imageUri.value
    )
    val launcher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent(),
        ) { uri: Uri? ->
            uri?.let {
                imageUri.value = it.toString()
            }
        }
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier
                .padding(8.dp).border(1.dp,color= Color(0xFF8A97B7),shape= CircleShape)
                .size(200.dp)
        ) {

            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        launcher.launch("image/*")
                    },
                contentScale = ContentScale.Crop
            )

        }
        Text(text = "Change Logo")
    }
}
*/
*/
@Composable
fun ProfileImage() {
    var showDialog by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    val img: Bitmap =
        BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image)
    val bitmap = remember {
        mutableStateOf(img)
    }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) {
            if (it != null) {
                bitmap.value = it
            }
        }
    val launchImage =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            } else {
                val source = it?.let { uri ->
                    ImageDecoder.createSource(context.contentResolver, uri)
                }
                bitmap.value = source?.let { uri ->
                    ImageDecoder.decodeBitmap(uri)
                }!!
            }
        }
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            Image(
                bitmap = bitmap.value.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(250.dp)
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color(0xFF8A97B7),
                        shape = CircleShape
                    )
                    .clickable {
                        showDialog = true
                    }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = " Change Logo")
        }



        Box(modifier = Modifier.padding(top = 220.dp, start = 240.dp)) {
            Image(
                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFF8A97B7))
                    .size(50.dp)
                    .padding(10.dp)
                    .clickable {
                        showDialog = true
                    }
            )
        }


        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp)
        ) {
            if (showDialog) {
                Dialog(onDismissRequest = { showDialog = false }) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,

                        modifier = Modifier
                            .padding(top = 400.dp)
                            .width(300.dp)
                            .height(100.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF8A97B7))
                    ) {
                        Column(modifier = Modifier.padding(start = 60.dp)) {
                            Image(
                                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable {
                                        launcher.launch()
                                        showDialog = false
                                    }
                            )
                            Text(
                                text = "Camera",
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.padding(30.dp))
                        Column {
                            Image(painter = painterResource(id = R.drawable.baseline_image_24),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clickable {
                                        launchImage.launch("image/*")
                                        showDialog = false
                                    })
                            Text(
                                text = "Gallery",
                                color = Color.White
                            )
                        }
                        Column(
                            modifier = Modifier.padding(
                                start = 45.dp,
                                bottom = 80.dp,
                                end = 8.dp
                            )
                        ) {
                            Text(
                                text = "x",
                                color = Color.White,
                                modifier = Modifier.clickable {
                                    showDialog = false
                                }
                            )
                        }
                    }

                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProfileTheme {
        ProfileScreen()
    }
}