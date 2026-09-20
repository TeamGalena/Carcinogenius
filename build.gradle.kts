plugins {
    id("com.possible-triangle.neoforge")
}

base {
    archivesName = "${mod.name.get()} ${mod.minecraftVersion.get()}-${mod.version.get()}"
}

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
        url = uri("https://maven.createmod.net")
        content {
            includeGroup("net.createmod.ponder")
            includeGroup("dev.engine-room.flywheel")
        }
    }
    nexus {
        content {
            includeGroup("dev.galena")
            includeGroup("com.possible-triangle")
        }
    }
}

dependencies {
    modImplementation(libs.oreganized)
    modRuntimeOnly(libs.multikulti.datagen)

    modRuntimeOnly(libs.jei)
}

upload {
    forEach {
        dependencies.required("oreganized")
    }
}