import zhupf.gadget.basic.Basic
import zhupf.gadget.logger.Logger
import zhupf.gadget.toast.Toast
import zhupf.gadget.widget.Widget

plugins {
    id("com.elysium.library")
}

script {
    configuration("com.elysium.basic") {
        configure()
    }
    dependency {
        common()
    }
}

gadgets {
    Basic {
        android("api")
    }
    Logger {
        logger("api")
    }
    Toast {
        toast("api")
    }
    Widget {
        widget("api")
        annotation("implementation")
        compile("ksp")
        dsl("implementation")
    }
}

dependencies {
    api(libs.androidx.constraintlayout)
    api(libs.androidx.recyclerview)
}