import SwiftUI

struct LoginView: View {
    @StateObject private var viewModel = LoginViewModel()
    
    var body: some View {
        ZStack {
            Image("background")
                .resizable()
                .scaledToFill()
                .edgesIgnoringSafeArea(.all)
            
            VStack {
                Image("sbot_icon")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 150, height: 150)
                    .padding(.bottom, 32)
                
                TextField("Số điện thoại", text: $viewModel.phoneNumber)
                    .padding(.leading, 40)
                    .padding(.vertical, 15)
                    .background(Color("F3F4F6"))
                    .cornerRadius(6)
                    .overlay(
                        HStack {
                            Image("user_icon")
                                .resizable()
                                .scaledToFit()
                                .frame(width: 24, height: 24)
                                .padding(.leading, 16)
                            Spacer()
                        }
                    )
                    .padding(.horizontal, 32)
                    .padding(.bottom, 16)
                
                SecureField("Mật khẩu", text: $viewModel.password)
                    .padding(.leading, 40)
                    .padding(.vertical, 15)
                    .background(Color("F3F4F6"))
                    .cornerRadius(6)
                    .overlay(
                        HStack {
                            Image("lock_icon")
                                .resizable()
                                .scaledToFit()
                                .frame(width: 24, height: 24)
                                .padding(.leading, 16)
                            Spacer()
                        }
                    )
                    .padding(.horizontal, 32)
                    .padding(.bottom, 16)
                
                Text("Lấy lại mật khẩu")
                    .foregroundColor(Color("FFDE08"))
                    .font(.system(size: 15))
                    .padding(.trailing, 32)
                    .padding(.bottom, 16)
                    .frame(maxWidth: .infinity, alignment: .trailing)
                
                Button(action: {
                    // Handle login
                }) {
                    Text("Đăng nhập")
                        .foregroundColor(.white)
                        .font(.system(size: 15))
                        .frame(maxWidth: .infinity)
                        .padding(.vertical, 15)
                        .background(Color("C20000"))
                        .cornerRadius(10)
                }
                .padding(.horizontal, 32)
            }
        }
    }
}

class LoginViewModel: ObservableObject {
    @Published var phoneNumber: String = ""
    @Published var password: String = ""
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
} 