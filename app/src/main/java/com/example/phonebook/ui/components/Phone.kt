package com.example.phonebook.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import com.example.phonebook.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.phonebook.util.fromHex
import androidx.compose.ui.unit.dp
import com.example.phonebook.domain.model.PhoneModel

@ExperimentalMaterialApi
@Composable
fun Phone(
    modifier: Modifier = Modifier,
    phone: PhoneModel,
    onPhoneClick: (PhoneModel) -> Unit = {},
) {

    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),

        ) {
        Surface(
            modifier = Modifier
                .border(2.dp, Color.Black, RoundedCornerShape(5.dp))

        ){
            ListItem(
                text = { Text(text = phone.title, maxLines = 1) },
                secondaryText = {
                    Text(text = phone.content, maxLines = 1)
                },
                icon = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.size(48.dp)
                    ){
                        PhoneColor(
                            color = Color.fromHex(phone.color.hex),
                            size = 50.dp,
                            border = 1.dp
                        )
                        if (phone.tag.nameTag == "Mobile") {
                            Icon(
                                painter = painterResource(R.drawable.baseline_phone_iphone_24),
                                contentDescription = "Mobile icon",
                                tint = MaterialTheme.colors.onPrimary
                            )
                        } else if (phone.tag.nameTag == "Home") {
                            Icon(
                                painter = painterResource(R.drawable.baseline_home_24),
                                contentDescription = "Mobile icon",
                                tint = MaterialTheme.colors.onPrimary
                            )
                        } else if (phone.tag.nameTag == "Work") {
                            Icon(
                                painter = painterResource(R.drawable.baseline_work_24),
                                contentDescription = "Mobile icon",
                                tint = MaterialTheme.colors.onPrimary
                            )
                        }
                    }

                },
                modifier = Modifier.clickable {
                    onPhoneClick.invoke(phone)
                }
            )
        }

    }
}