pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ru.mirea.rastopchin.Lesson9"
include(":app")
include(":retrofitapp")
include(":scrollviewapp")
include(":listviewapp")
include(":historyevents")
include(":fragmentapp")
include(":fragmentmanagerapp")
include(":resultapifragmentapp")
include(":navigationdrawerapp")
include(":bottomnavigationapp")
