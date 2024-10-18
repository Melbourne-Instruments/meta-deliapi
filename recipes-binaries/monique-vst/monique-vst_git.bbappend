SRCREV = "c95e0702f3f024dbdaff2dd74a6f0c5384aae772"
PV = "1.0.3+${AUTOREV}"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Debug \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DSMTG_ADD_VST3_PLUGINS_SAMPLES=TRUE \
    -DCMAKE_SKIP_RPATH=TRUE \
"

do_install_append() {
}

