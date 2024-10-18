SRCREV = "4964a42cc641dfeb15c6b29e8e295d2b60b8ab5b"
PV = "1.1.0+${SRCREV}"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://monique.rbf \
"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_SKIP_RPATH=TRUE \
    -DNINA_PI_HAT=FALSE \
    -DDELIA_PI_HAT=TRUE \
"

ROOT_HOME_DIR = "/home/root"

do_install_append() {
    install -d ${D}${ROOT_HOME_DIR}
    install -d ${D}${ROOT_HOME_DIR}/delia
    install -d ${D}${ROOT_HOME_DIR}/delia/firmware    
    cp "${WORKDIR}/monique.rbf" ${D}${ROOT_HOME_DIR}/delia/firmware
}

FILES_${PN} += "${ROOT_HOME_DIR}/delia/firmware/monique.rbf \               
"
