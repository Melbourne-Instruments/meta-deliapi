SRCREV = "45fa00e290a323fa2fa4568f9e603bbaa74eed37"
PV = "1.0.6+${AUTOREV}"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
    -DCMAKE_SKIP_RPATH=TRUE \
"