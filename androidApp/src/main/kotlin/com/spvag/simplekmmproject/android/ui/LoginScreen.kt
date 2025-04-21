package com.spvag.simplekmmproject.android.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.spvag.simplekmmproject.android.R

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // SBOT Icon
            Image(
                painter = painterResource(id = R.drawable.sbot_icon),
                contentDescription = "SBOT Icon",
                modifier = Modifier
                    .size(120.dp)
                    .padding(bottom = 40.dp)
            )

            // Phone Number Input
            InputField(
                value = viewModel.phoneNumber,
                onValueChange = { viewModel.updatePhoneNumber(it) },
                placeholder = "Số điện thoại",
                leadingIcon = R.drawable.user_icon_login,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )

            // Password Input
            InputField(
                value = viewModel.password,
                onValueChange = { viewModel.updatePassword(it) },
                placeholder = "Mật khẩu",
                leadingIcon = R.drawable.lock_icon_login,
                isPassword = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            )

            // Recover Password Text
            Text(
                text = "Lấy lại mật khẩu",
                color = Color(0xFFFFDE08),
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 24.dp)
            )

            // Login Button
            Button(
                onClick = { /* Handle login */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC20000))
            ) {
                Text(
                    text = "Đăng nhập",
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: Int,
    isPassword: Boolean = false,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color(0xFFF3F4F6), shape = RoundedCornerShape(6.dp))
            .border(1.dp, Color.Transparent, shape = RoundedCornerShape(6.dp))
            .height(48.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = leadingIcon),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .padding(end = 12.dp)
            )

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .weight(1f),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif
                ),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = Color(0xFFBDC1CA),
                            fontSize = 15.sp,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                    innerTextField()
                },
                visualTransformation = if (isPassword) PasswordVisualTransformation() else androidx.compose.ui.text.input.VisualTransformation.None
            )
        }
    }
} 