# CONFIGURAÇÃO DE AMBIENTE

## FERRAMENTAS NECESSÁRIAS
* JAVA
* ECLIPSE
* ANDROID STUDIO
* EMULADOR
* APPIUM

## INSTALAÇÃO
* Instalar e configurar android studio

## CONFIGURAÇÕES

#### Menu Configurações >> SDK Manager

### SDK Plataform
* Instalar as versões do android que vou automatizar;

### SDK Tools
* Android SDK Tools, Android Emulator, Android SDK Build tools, Android SDK Plataform tools
* Copiar Android SDK Location: C:\Users\Auditeste0242\AppData\Local\Android\Sdk
* Apply para baixar e instalar

### Variáveis de Ambiente
#### Variáveis de Ambiente do Sistema
* JAVA_HOME: C:\Program Files\Java\jdk1.8.0_201
* ANDROID_HOME: C:\Users\Auditeste0242\AppData\Local\Android\Sdk (Cópia do caminho Android SDK Location)
* Adicionar os caminhos ao path: %ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools

### Teste
#### No cmd executar os comandos:
* adb
* emulator (Vai dar erro por não passar os parametros)
* uiautomatorviewer (deve abrir a ferramenta)

## INSTALAÇÃO EMULADOR ANDROID

* No ANDROID STUDIO criar novo projeto
* Clicar no botão ADV Manager (icone de um celular)
* Selecionar especificações do aparelho e executar

### Abrir Emulador Via terminal
* emulator -list-avds (lista aparelhos)
* cd %ANDROID_HOME% (caso não esteja na pasta)
* cd tools
* emulator @Aparelho criado

### Instalar o Appitum
https://github.com/appium/appium-desktop/releases
*** OBS: versão windows appium-desktop-setup-x.x.x.exe

* Executar e ligar servidor

# GRAVAÇÃO

## INSPETOR DE ELEMENTOS

Depois de iniciar o servidor, configurar o "Desired Capabilities":

* platformName, text, Android
* deviceName, text, emulator-5554 (para buscar nome do device conectado - cmd adb devices) *** Obrigatório apenas para IOS
* automationName, text, uiautomator2
* baixar APKInfo instalar no emulador (arrastando o o instalador para o emulador ou baixando pelo google playstore)
* Abrir o apkinfo fazer um click longo no app que sera automatizado "Detailed Info"
* Pegar as info de Activities
* Linha 1: appPackage sem a classe no final
	Ex: com.android.calculator2
* Linha 2: appActivity
	Ex: com.android.calculator2.Calculator
* Selecionar aba "Automatic Server" e "Start Session" (Caso não funcione verificar se a opção "Allow Unauthorized Certificates" esta marcada em config avançada
*** Ref: https://stackoverflow.com/questions/48127882/error-could-not-connect-to-server-are-you-sure-its-running-in-appium
* Efetuar a gravação

# Projeto

No eclipse criar um projeto Maven com as dependencias:

<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>5.0.4</version>
</dependency>


