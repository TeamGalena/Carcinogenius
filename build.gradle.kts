plugins {
    id("com.possible-triangle.neoforge")
}

// base {
//     archivesName = "$mod_name $minecraft_version-$mod_version"
// }

neoforge {
    dataGen {
        existing("blueprint")
    }
}

repositories {
    maven {
        url = uri("https://maven.teamabnormals.com/")
        content {
            includeGroup("com.teamabnormals")
        }
    }
    maven {
        url = uri("https://maven.blamejared.com/")
        content {
            includeGroup("mezz.jei")
        }
    }
    maven {
        url = uri("https://api.modrinth.com/maven")
        content {
            includeGroup("maven.modrinth")
        }
    }
    nexus {
        content {
            includeGroup("dev.galena")
            includeGroup("com.possible-triangle")
        }
    }
}

val oreganized_version: String by extra
val multikulti_version: String by extra
val minecraft_version: String by extra
val jei_version: String by extra
val jade_version: String by extra

dependencies {
    modImplementation("dev.galena:oreganized:${oreganized_version}")
    modRuntimeOnly("com.possible-triangle:multikulti-datagen-neoforge:${minecraft_version}-${multikulti_version}")

    // For dev testing
    modRuntimeOnly("maven.modrinth:jade:${jade_version}")

    modCompileOnly("mezz.jei:jei-${minecraft_version}-common-api:${jei_version}")
    modCompileOnly("mezz.jei:jei-${minecraft_version}-neoforge-api:${jei_version}")
    modRuntimeOnly("mezz.jei:jei-${minecraft_version}-neoforge:${jei_version}")
}

upload {
    forEach {
        dependencies.required("oreganized")
    }
}