pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenLocal() // 👈 Aquí debe ir PARA LEER PUBLICACIONES LOCALES
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenLocal() // 👈 Aquí debe ir PARA LEER PUBLICACIONES LOCALES
        google()
        mavenCentral()
    }
}

rootProject.name = "MyApplication4"
include(":app")
 