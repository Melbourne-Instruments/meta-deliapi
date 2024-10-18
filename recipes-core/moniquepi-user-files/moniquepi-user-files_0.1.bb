SUMMARY = "Config files and scripts for the DELIA OS image"
HOMEPAGE = "https://github.com/Melbourne-Instruments/meta-ninapi"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/Melbourne-Instruments/configs.git \
           file://wavetables.tar.xz;unpack=0 \
           file://bin.zip \
           file://bashrc \
           file://WenQuanYi-Micro-Hei-Regular.ttf \
           "
SRCREV = "f64769320d6c1b8eb5eb5dd32a8c0c156dd54714"

do_install[nostamp] = "1"

ROOT_HOME_DIR = "/home/root"
DELIA_HOME_DIR = "/home/delia"
USR_SHARE_FONTS_TTF_DIR = "/usr/share/fonts/ttf"

do_install () {
    install -d ${D}${DELIA_HOME_DIR}
    install -d ${D}${ROOT_HOME_DIR}
    install -d ${D}${ROOT_HOME_DIR}/delia
    install -d ${D}${ROOT_HOME_DIR}/delia/scripts
    install -d ${D}${ROOT_HOME_DIR}/delia/firmware
    install -d ${D}${USR_SHARE_FONTS_TTF_DIR}
    install -m 0666 ${WORKDIR}/bashrc ${D}${ROOT_HOME_DIR}
    install -m 0666 ${WORKDIR}/WenQuanYi-Micro-Hei-Regular.ttf ${D}${USR_SHARE_FONTS_TTF_DIR}
    mv ${D}${ROOT_HOME_DIR}/bashrc ${D}${ROOT_HOME_DIR}/.bashrc
    cp ${WORKDIR}/git/delia/ui/haptic_modes.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/ui/param_map.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/ui/param_attributes.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/ui/param_lists.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/ui/param_blacklist.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/ui/system_colours.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/ui/BASIC_PRESET.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/sushi/config_delia.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/sushi/config_factory_test.json ${D}${ROOT_HOME_DIR}/delia
    cp ${WORKDIR}/git/delia/scripts/addBank.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/backup.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/backupUserWt.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/bank_add.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/bank_clear.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/bank_export.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/bank_import_merge.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/bank_import_merge_check.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/bank_import_overwrite.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/bl_regmap.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/calibrate.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/crc.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/demo_mode.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/demoMode.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/factoryWtList.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/i2c.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/ledTest.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/intelhex.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/kill_python.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/load_pc_fw.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/load_mc_fw.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/loadUserWt.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/loadWt.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/nina/scripts/log_temp.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/mc_regmap.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/mergeBank.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/mergePresets.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/motor_test.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/overwriteBank.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/presetUpdate.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/restore_backup.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/soak_test.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/soakTest.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/soakTestInterface.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/system_test.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/system_test.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/nina/scripts/wavfile.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/wtExportBank.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/wtPrune.py ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/wt_export.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/wt_import.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    cp ${WORKDIR}/git/delia/scripts/wt_prune.sh ${D}${ROOT_HOME_DIR}/delia/scripts
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/backup.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/bank_add.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/bank_clear.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/bank_export.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/bank_import_merge.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/bank_import_merge_check.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/bank_import_overwrite.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/calibrate.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/demo_mode.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/loadWt.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/kill_python.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/log_temp.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/motor_test.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/restore_backup.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/soak_test.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/system_test.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/wt_export.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/wt_import.sh
    chmod 0755 ${D}${ROOT_HOME_DIR}/delia/scripts/wt_prune.sh

    # Add a temporary file to the /usr/bin folder that can be deleted to create space in rootfs
    # if needed
    install -d ${D}${bindir}
    install -m 0666 ${WORKDIR}/bin.tmp ${D}${bindir}  

    # Workaround - copy to the deploy image directory, which are then
    # copied into the userdata (/udata) partition
    # Note - make the deploy directory if it doesn't exist
    if ! [ -d ${DEPLOY_DIR_IMAGE} ]; then
        mkdir -p ${DEPLOY_DIR_IMAGE}
    fi
    chmod 0755 ${DEPLOY_DIR_IMAGE}    
    cp ${WORKDIR}/git/delia/ui/config.json ${DEPLOY_DIR_IMAGE}/config.json
    cp ${WORKDIR}/git/delia/test_patches/001_FACTORY_TEST.json ${DEPLOY_DIR_IMAGE}/001_FACTORY_TEST.json
    cp ${WORKDIR}/wavetables.tar.xz ${DEPLOY_DIR_IMAGE}/wavetables.tar.xz
}

FILES_${PN} += "${ROOT_HOME_DIR}"
FILES_${PN} += "${ROOT_HOME_DIR}/*"
FILES_${PN} += "${DELIA_HOME_DIR}"
FILES_${PN} += "${DELIA_HOME_DIR}/*"
FILES_${PN} += "${USR_SHARE_FONTS_TTF_DIR}"
FILES_${PN} += "${USR_SHARE_FONTS_TTF_DIR}/*"
